/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.as.quickstarts.dxrest;

import org.jboss.as.quickstarts.dxmodel.Arriving;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A simple CDI service which is able to say hello to someone
 *
 * @author Pete Muir
 *
 */
public class HelloService {

    HelloData helloData = HelloData.getInstance();

    String createHelloMessage(String name) {
        return "Nothing found for [ " + name + " ]";
    }

    List<Arriving> getArrivingsForStation(String stationID) {
        ArrayList<Arriving> ret = new ArrayList<>();

        int delayInMin;

        switch (stationID){
            case "12":
            case "etf":
                delayInMin = 7;
                for (Arriving a:getLineWithDelay("line17_2",delayInMin,"17","Obilicevo","Nova Bolnica")){
                    ret.add(a);
                }
                break;
            case "13":
            case "bulevar":

                delayInMin = 20;
                for (Arriving a:getLineWithDelay("line1_2",delayInMin,"1","Ortopedija","Nova Bolnica")){
                    ret.add(a);
                }

                delayInMin = 8;
                for (Arriving a:getLineWithDelay("line17_2",delayInMin,"1","Obilicevo","Nova Bolnica")){
                    ret.add(a);
                }

                break;
            case "vidik":
            case "0":
                delayInMin = 0;
                for (Arriving a:getLineWithDelay("line1_1",delayInMin,"1","Nova Bolnica","Ortopedija")){
                    ret.add(a);
                }

                for (Arriving a:getLineWithDelay("line17_1",delayInMin,"17","Nova Bolnica","Obilicevo")){
                    ret.add(a);
                }
                break;
        }

        Collections.sort(ret);

        int LIMIT = 10;
        //System.out.println("SIZE: " + ret.size());
        return ret.subList(0,ret.size()<LIMIT?ret.size():LIMIT);
    }

    private ArrayList<Arriving> getLineWithDelay(String lineID, int delayInMin, String line, String from, String to){
        ArrayList<Arriving> ret = new ArrayList<>();
        String [] schedule;
        Arriving a = new Arriving();
        schedule = helloData.getArrivings(lineID).split(";");
        for (String s:schedule){
            LocalTime time = LocalTime.parse(s, DateTimeFormatter.ofPattern("H:mm"));
            if (time.isAfter(LocalTime.now(ZoneId.of("Europe/Belgrade")).minusMinutes(delayInMin + 3))){
                a = new Arriving(line,from,to, time, time.plusMinutes(delayInMin));
                ret.add(a);
            }
        }
        return ret;
    }

}
