#version 330

// come from the default raylib vertex shader
// https://raw.githubusercontent.com/raysan5/raylib/refs/heads/master/src/rlgl.h const char *defaultVShaderCode
in vec2 fragTexCoord;
in vec4 fragColor;

// also preset by raylib?
uniform sampler2D texture0;
uniform vec4 colDiffuse;

// also preset by raylib
out vec4 finalColor;

// NOTE: Render size values must be passed from code
const float renderWidth = 800;
const float renderHeight = 450;

float offset = 0.0;

uniform float time;


void main() {
    float frequency = renderHeight / 3.0;

    float globalPos = (fragTexCoord.y + offset) * frequency;
    float wavePos = cos((fract(globalPos) - 0.5) * 3.14);

    vec4 texelColor = texture(texture0, fragTexCoord);
//    finalColor = texelColor;

    finalColor = mix(vec4(0.0, 0.3, 0.0, 0.0), texelColor, wavePos);
}

