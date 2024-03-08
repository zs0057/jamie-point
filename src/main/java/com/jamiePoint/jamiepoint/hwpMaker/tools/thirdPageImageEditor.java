package com.jamiePoint.jamiepoint.hwpMaker.tools;

import java.awt.Rectangle;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.jamiePoint.jamiepoint.hwpController.user.UserInfoForm;

import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.object.bodytext.control.ControlTable;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.CtrlHeaderGso;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.gso.GsoHeaderProperty;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.gso.HeightCriterion;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.gso.HorzRelTo;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.gso.ObjectNumberSort;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.gso.RelativeArrange;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.gso.TextFlowMethod;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.gso.TextHorzArrange;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.gso.VertRelTo;
import kr.dogfoot.hwplib.object.bodytext.control.ctrlheader.gso.WidthCriterion;
import kr.dogfoot.hwplib.object.bodytext.control.gso.ControlRectangle;
import kr.dogfoot.hwplib.object.bodytext.control.gso.GsoControlType;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.ShapeComponentNormal;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.lineinfo.LineArrowShape;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.lineinfo.LineArrowSize;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.lineinfo.LineEndShape;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.lineinfo.LineInfo;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.lineinfo.LineType;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.lineinfo.OutlineStyle;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.shadowinfo.ShadowInfo;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponent.shadowinfo.ShadowType;
import kr.dogfoot.hwplib.object.bodytext.control.gso.shapecomponenteach.ShapeComponentRectangle;
import kr.dogfoot.hwplib.object.bodytext.control.table.Cell;
import kr.dogfoot.hwplib.object.bodytext.control.table.Row;
import kr.dogfoot.hwplib.object.bodytext.paragraph.Paragraph;
import kr.dogfoot.hwplib.object.bodytext.paragraph.text.ParaText;
import kr.dogfoot.hwplib.object.docinfo.BinData;
import kr.dogfoot.hwplib.object.docinfo.bindata.BinDataCompress;
import kr.dogfoot.hwplib.object.docinfo.bindata.BinDataState;
import kr.dogfoot.hwplib.object.docinfo.bindata.BinDataType;
import kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo.FillInfo;
import kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo.ImageFill;
import kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo.ImageFillType;
import kr.dogfoot.hwplib.object.docinfo.borderfill.fillinfo.PictureEffect;

public class thirdPageImageEditor {
	public static void bojImageToHwp(ControlTable curCtr, HWPFile hwpFile, UserInfoForm userinfoForm) {

        Row seventhRow = curCtr.getRowList().get(3);
        Cell seventhCell = seventhRow.getCellList().get(0);
        
        int streamIndex = hwpFile.getBinData().getEmbeddedBinaryDataList().size() + 1;
        String streamName = getStreamName(streamIndex);
        String imgFilePath = "basic_hwp" + File.separator + "image" + File.separator + "boj.png";
        
        byte[] fileBinary = null;
		try {
			fileBinary = loadFile(imgFilePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String imageFileExt = "jpg";
		BinDataCompress compressMethod = BinDataCompress.ByStorageDefault;
		
        hwpFile.getBinData().addNewEmbeddedBinaryData(streamName, fileBinary, compressMethod);
  
        BinData bd = new BinData();
        bd.getProperty().setType(BinDataType.Embedding);
        bd.getProperty().setCompress(compressMethod);
        bd.getProperty().setState(BinDataState.NotAccess);
        bd.setBinDataID(streamIndex);
        bd.setExtensionForEmbedding(imageFileExt);
        hwpFile.getDocInfo().getBinDataList().add(bd);
        
        int binDataID = hwpFile.getDocInfo().getBinDataList().size();
        int instanceID = 0x5bb840e1;
        
        Paragraph firstPara = seventhCell.getParagraphList().getParagraph(0);
        ParaText paraText = firstPara.getText();
        
        if (paraText == null) {
        	
            firstPara.createText();
            paraText = firstPara.getText();
        }

        // 문단에서 사각형 컨트롤의 위치를 표현하기 위한 확장 문자를 넣는다.
        paraText.addExtendCharForGSO();
        
        // 문단에 사각형 컨트롤 추가한다.
        ControlRectangle rectangle = (ControlRectangle) firstPara.addNewGsoControl(GsoControlType.Rectangle);
        Rectangle shapePosition = new Rectangle(0, 0, 160, 100);
        CtrlHeaderGso hdr = rectangle.getHeader();
        GsoHeaderProperty prop = hdr.getProperty();
        prop.setLikeWord(true);
        prop.setApplyLineSpace(false);
        prop.setVertRelTo(VertRelTo.Para);
        prop.setVertRelativeArrange(RelativeArrange.Center);
        prop.setHorzRelTo(HorzRelTo.Para);
        prop.setHorzRelativeArrange(RelativeArrange.Center);
        prop.setVertRelToParaLimit(true);
        prop.setAllowOverlap(true);
        prop.setWidthCriterion(WidthCriterion.Absolute);
        prop.setHeightCriterion(HeightCriterion.Absolute);
        prop.setProtectSize(false);
        prop.setTextFlowMethod(TextFlowMethod.FitWithText);
        prop.setTextHorzArrange(TextHorzArrange.BothSides);
        prop.setObjectNumberSort(ObjectNumberSort.Figure);

        hdr.setyOffset(fromMM(shapePosition.y));
        hdr.setxOffset(fromMM(shapePosition.x));
        hdr.setWidth(fromMM(shapePosition.width));
        hdr.setHeight(fromMM(shapePosition.height));
        hdr.setzOrder(0);
        hdr.setOutterMarginLeft(0);
        hdr.setOutterMarginRight(0);
        hdr.setOutterMarginTop(0);
        hdr.setOutterMarginBottom(0);
        hdr.setInstanceId(instanceID);
        hdr.setPreventPageDivide(false);
        hdr.getExplanation().setBytes(null);
        
        ShapeComponentNormal sc = (ShapeComponentNormal) rectangle.getShapeComponent();
        sc.setOffsetX(0);
        sc.setOffsetY(0);
        sc.setGroupingCount(0);
        sc.setLocalFileVersion(1);
        sc.setWidthAtCreate(fromMM(shapePosition.width));
        sc.setHeightAtCreate(fromMM(shapePosition.height));
        sc.setWidthAtCurrent(fromMM(shapePosition.width));
        sc.setHeightAtCurrent(fromMM(shapePosition.height));
        sc.setRotateAngle(0);
        sc.setRotateXCenter(fromMM(shapePosition.width / 2));
        sc.setRotateYCenter(fromMM(shapePosition.height / 2));

        sc.createLineInfo();
        LineInfo li = sc.getLineInfo();
        li.getProperty().setLineEndShape(LineEndShape.Flat);
        li.getProperty().setStartArrowShape(LineArrowShape.None);
        li.getProperty().setStartArrowSize(LineArrowSize.MiddleMiddle);
        li.getProperty().setEndArrowShape(LineArrowShape.None);
        li.getProperty().setEndArrowSize(LineArrowSize.MiddleMiddle);
        li.getProperty().setFillStartArrow(true);
        li.getProperty().setFillEndArrow(true);
        li.getProperty().setLineType(LineType.None);
        li.setOutlineStyle(OutlineStyle.Normal);
        li.setThickness(0);
        li.getColor().setValue(0);

        sc.createFillInfo();
        
        FillInfo fi = sc.getFillInfo();
        fi.getType().setPatternFill(false);
        fi.getType().setImageFill(true);
        fi.getType().setGradientFill(false);
        fi.createImageFill();
        
        ImageFill imgF = fi.getImageFill();
        imgF.setImageFillType(ImageFillType.FitSize);
        imgF.getPictureInfo().setBrightness((byte) 0);
        imgF.getPictureInfo().setContrast((byte) 0);
        imgF.getPictureInfo().setEffect(PictureEffect.RealPicture);
        imgF.getPictureInfo().setBinItemID(binDataID);

        sc.createShadowInfo();
        ShadowInfo si = sc.getShadowInfo();
        si.setType(ShadowType.None);
        si.getColor().setValue(0xc4c4c4);
        si.setOffsetX(0);
        si.setOffsetY(0);
        si.setTransparent((short) 0);

        sc.setMatrixsNormal();
        
        ShapeComponentRectangle scr = rectangle.getShapeComponentRectangle();
        scr.setRoundRate((byte) 0);
        scr.setX1(0);
        scr.setY1(0);	
        scr.setX2(fromMM(shapePosition.width));
        scr.setY2(0);
        scr.setX3(fromMM(shapePosition.width));
        scr.setY3(fromMM(shapePosition.height));
        scr.setX4(0);
        scr.setY4(fromMM(shapePosition.height));
        
        
    }

	private static String getStreamName(int streamIndex) {
	    return "Bin" + String.format("%04X", streamIndex) + "." + "jpg";
	}

	private static byte[] loadFile(String imageFilePath) throws IOException {
	    File file = new File(imageFilePath);
	    byte[] buffer = new byte[(int) file.length()];
	    InputStream ios = null;
	    try {
	        ios = new FileInputStream(file);
	        ios.read(buffer);
	    } finally {
	        try {
	            if (ios != null)
	                ios.close();
	        } catch (IOException e) {
	        }
	    }
	    return buffer;
	}
	private static int fromMM(int mm) {
	    if (mm == 0) {
	        return 1;
	    }
	
	    return (int) ((double) mm * 72000.0f / 254.0f + 0.5f);
	}

}
