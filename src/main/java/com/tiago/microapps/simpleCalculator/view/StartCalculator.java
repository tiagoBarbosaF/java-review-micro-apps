package com.tiago.microapps.simpleCalculator.view;

import com.tiago.microapps.simpleCalculator.services.FileService;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class StartCalculator {

    public static void Start() {
        Path path = Paths.get("HistoricCalculator.txt");
        String content = "[1,SUM], 10,10";
        String content2 = "[2,SUM],30,40";
        String content3 = "[3,SUBTRACTION],40,30";
        String content4 = "[4,MULTIPLICATION],4,3";

        HashMap<Map.Entry<Integer, String>, String> map = new HashMap<>();

        FileService.addContent(content4);
        FileService.getHistoricFromFile();
    }
}
