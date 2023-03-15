package com.example.ffmpegbuildpackex;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor(staticName = "create")
@ToString
@Getter
public class DimensionResponse {
    int width;
    int height;
}
