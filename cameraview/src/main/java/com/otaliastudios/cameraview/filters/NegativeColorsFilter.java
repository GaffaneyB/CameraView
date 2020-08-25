package com.otaliastudios.cameraview.filters;

import androidx.annotation.NonNull;

import com.otaliastudios.cameraview.filter.BaseFilter;

/**
 * Inverts the input colors and subtracts the orange mask for color photographic negatives.
 */
public class NegativeColorsFilter extends BaseFilter {

    private final static String FRAGMENT_SHADER = "#extension GL_OES_EGL_image_external : require\n"
            + "precision mediump float;\n"
            + "varying vec2 "+DEFAULT_FRAGMENT_TEXTURE_COORDINATE_NAME+";\n"
            + "uniform samplerExternalOES sTexture;\n"
            + "void main() {\n"
            + "  float maskR = 175.0/255.0;\n"
            + "  float maskG = 130.0/255.0;\n"
            + "  float maskB = 95.0/255.0;\n"
            + "  vec4 mask = vec4(maskR, maskG, maskB, 1.0);\n"
            + "  vec4 color = texture2D(sTexture, "+DEFAULT_FRAGMENT_TEXTURE_COORDINATE_NAME+");\n"
            + "  float colorR = (1.0 - color.r + mask.r) / 2.0;\n"
            + "  float colorG = (1.0 - color.g + mask.g) / 2.0;\n"
            + "  float colorB = (1.0 - color.b + mask.b) / 2.0;\n"
            + "  gl_FragColor = vec4(colorR, colorG, colorB, color.a);\n"
            + "}\n";

    public NegativeColorsFilter() { }

    @NonNull
    @Override
    public String getFragmentShader() {
        return FRAGMENT_SHADER;
    }
}


/* ******************************
    private final static String FRAGMENT_SHADER = "#extension GL_OES_EGL_image_external : require\n"
            + "precision mediump float;\n"
            + "varying vec2 "+DEFAULT_FRAGMENT_TEXTURE_COORDINATE_NAME+";\n"
            + "uniform samplerExternalOES sTexture;\n"
            + "void main() {\n"
            + "  float maskR = 166.0/255.0;\n"
            + "  float maskG = 110.0/255.0;\n"
            + "  float maskB = 83.0/255.0;\n"
            + "  vec4 mask = vec4(maskR, maskG, maskB, 1.0);\n"
            + "  vec4 color = texture2D(sTexture, "+DEFAULT_FRAGMENT_TEXTURE_COORDINATE_NAME+");\n"
            + "  float colorR = (1.0 - color.r + mask.r) / 1.0;\n"
            + "  float colorG = (1.0 - color.g + mask.g) / 1.0;\n"
            + "  float colorB = (1.0 - color.b + mask.b) / 1.0;\n"
            + "  gl_FragColor = vec4(colorR, colorG, colorB, color.a);\n"
            + "}\n";
   ****************************** */