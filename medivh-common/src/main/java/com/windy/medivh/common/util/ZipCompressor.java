package com.windy.medivh.common.util;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;

import java.io.File;


public class ZipCompressor {
    public static void compress(File srcDir, File destFile) {

        if (!srcDir.exists())
            throw new RuntimeException(srcDir.getAbsolutePath() + "不存在！");

        Project project = new Project();
        Zip zip = new Zip();
        zip.setProject(project);
        zip.setDestFile(destFile);

        FileSet fileSet = new FileSet();
        fileSet.setProject(project);
        fileSet.setDir(srcDir);

        zip.addFileset(fileSet);
        zip.execute();
    }

}