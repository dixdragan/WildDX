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

    private static final String line1_2 = "5:30;5:45;6:00;6:15;6:30;6:45;7:00;7:15;7:30;7:45;8:00;8:15;8:30;8:45;" +
            "9:00;9:15;9:30;9:45;10:00;10:15;10:30;10:45;11:00;11:30;11:45;12:00;12:15;12:30;12:45;13:00;13:15;13:30;" +
            "13:45;14:00;14:15;14:30;14:45;15:00;15:15;15:30;15:45;" +
            "16:00;16:15;16:30;16:45;17:00;17:15;17:30;17:45;18:00;18:15;18:30;18:45;19:00;19:30;20:00;20:30;" +
            "21:00;21:30;22:00;23:00";

    private static final String line17_2 = "5:30;5:50;6:10;6:30;6:50;7:10;7:30;7:50;8:10;8:30;" +
            "9:00;9:30;10:00;10:30;11:00;11:30;11:50;" +
            "12:10;12:30;12:50;13:10;13:30;13:50;14:10;14:30;14:50;15:10;15:30;15:50;" +
            "16:10;16:30;17:00;17:30;18:00;18:30;19:00;19:30;19:50;20:30;21:10;21:50";

    String createHelloMessage(String name) {
        return "Nothing found for [ " + name + " ]";
    }

    List<Arriving> getArrivingsForStation(String stationID) {
        ArrayList<Arriving> ret = new ArrayList<>();
        Arriving a = new Arriving();
        int delayInMin;
        String [] schedule;
        switch (stationID){
            case "etf":
                delayInMin = 7;
                schedule = line17_2.split(";");
                for (String s:schedule){
                    LocalTime time = LocalTime.parse(s, DateTimeFormatter.ofPattern("H:mm"));
                    if (time.isAfter(LocalTime.now(ZoneId.of("Europe/Belgrade")).minusMinutes(delayInMin + 3))){
                        a = new Arriving("17","Obilicevo","Nova Bolnica", time, time.plusMinutes(delayInMin));
                        ret.add(a);
                    }
                }
                break;
            case "bulevar":
                schedule = line1_2.split(";");
                delayInMin = 20;
                for (String s:schedule){
                    LocalTime time = LocalTime.parse(s, DateTimeFormatter.ofPattern("H:mm"));
                    if (time.isAfter(LocalTime.now(ZoneId.of("Europe/Belgrade")).minusMinutes(delayInMin + 3))){
                        a = new Arriving("1","Ortopedija","Nova Bolnica", time, time.plusMinutes(delayInMin));
                        ret.add(a);
                    }
                }

                schedule = line17_2.split(";");
                delayInMin = 8;
                for (String s:schedule){
                    LocalTime time = LocalTime.parse(s, DateTimeFormatter.ofPattern("H:mm"));
                    if (time.isAfter(LocalTime.now(ZoneId.of("Europe/Belgrade")).minusMinutes(delayInMin + 3))){
                        a = new Arriving("17","Obilicevo","Nova Bolnica", time, time.plusMinutes(delayInMin));
                        ret.add(a);
                    }
                }
                break;
        }

        Collections.sort(ret);

        int LIMIT = 10;
        System.out.println("SIZE: " + ret.size());


        return ret.subList(0,ret.size()<LIMIT?ret.size():LIMIT);
    }

}
