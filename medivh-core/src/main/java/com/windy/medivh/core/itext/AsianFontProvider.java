package com.windy.medivh.core.itext;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by alex on 17/2/17.
 */
public class AsianFontProvider extends XMLWorkerFontProvider {

    private final Logger logger = LoggerFactory.getLogger(AsianFontProvider.class);

    public Font getFont(final String fontName, final String encoding,
                        final boolean embedded, final float size, final int style,
                        final BaseColor color) {
        BaseFont baseFont = null;
        try {
//            bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            baseFont = BaseFont.createFont("simsun.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        } catch (Throwable e) {
            logger.error("生成字体集失败", e);
        }
        Font font = new Font(baseFont, size, style, color);
        font.setColor(color);
        return font;
    }
}
