package com.example.ffmpegbuildpackex;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.probe.FFmpegProbeResult;
import net.bramp.ffmpeg.probe.FFmpegStream;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Slf4j
@UtilityClass
public class MediaUtils {
    DimensionResponse getDimension(MultipartFile file) {
        try {
            File tempFile = File.createTempFile("temp", ".dat");
            file.transferTo(tempFile);

            FFprobe ffProbe = new FFprobe();
            FFmpegProbeResult probeResult = ffProbe.probe(tempFile.getPath());
            FFmpegStream stream = probeResult.getStreams().stream()
                    .filter(it -> it.codec_type == FFmpegStream.CodecType.VIDEO).findFirst()
                    .orElse(null);
            if (stream == null) {
                return DimensionResponse.create(0, 0);
            }

            tempFile.delete();

            log.info("origin video width x height : {} x {}.",
                    stream.width, stream.height);
            return DimensionResponse.create(stream.width, stream.height);
        } catch (Exception e) {
            log.warn("fail to get video origin width and height.", e);
            return null;
        }
    }
}
