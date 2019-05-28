package org.jboss.as.quickstarts.dxrest;

import java.util.HashMap;

public class HelloData {

    private static HelloData INSTANCE;
    private HashMap<String,String> data;

    private static final String line1_1 = "5:30;5:45;6:00;6:15;6:30;6:45;7:00;7:15;7:30;7:45;8:00;8:15;8:30;8:45;" +
            "9:00;9:15;9:30;9:45;10:00;10:15;10:30;10:45;11:00;11:15;11:30;11:45;12:00;12:15;12:30;12:45;13:00;13:15;13:30;" +
            "13:45;14:00;14:15;14:30;14:45;15:00;15:15;15:30;15:45;" +
            "16:00;16:15;16:30;16:45;17:00;17:15;17:30;17:45;18:00;18:15;18:30;18:45;19:00;19:30;20:00;20:30;" +
            "21:00;21:30;22:00;22:30;23:00";
    private static final String line1_2 = "5:30;5:45;6:00;6:15;6:30;6:45;7:00;7:15;7:30;7:45;8:00;8:15;8:30;8:45;" +
            "9:00;9:15;9:30;9:45;10:00;10:15;10:30;10:45;11:00;11:30;11:45;12:00;12:15;12:30;12:45;13:00;13:15;13:30;" +
            "13:45;14:00;14:15;14:30;14:45;15:00;15:15;15:30;15:45;" +
            "16:00;16:15;16:30;16:45;17:00;17:15;17:30;17:45;18:00;18:15;18:30;18:45;19:00;19:30;20:00;20:30;" +
            "21:00;21:30;22:00;22:30;23:00";

    private static final String line17_1 = "5:30;5:50;6:10;6:30;6:50;7:10;7:30;7:50;8:10;8:30;" +
            "9:00;9:30;10:00;10:30;11:00;11:30;11:50;" +
            "12:10;12:30;12:50;13:10;13:30;13:50;14:10;14:30;14:50;15:10;15:30;15:50;" +
            "16:10;16:30;17:00;17:30;18:00;18:30;19:00;19:30;20:10;20:50;21:30;22:10";

    private static final String line17_2 = "5:30;5:50;6:10;6:30;6:50;7:10;7:30;7:50;8:10;8:30;" +
            "9:00;9:30;10:00;10:30;11:00;11:30;11:50;" +
            "12:10;12:30;12:50;13:10;13:30;13:50;14:10;14:30;14:50;15:10;15:30;15:50;" +
            "16:10;16:30;17:00;17:30;18:00;18:30;19:00;19:30;19:50;20:30;21:10;21:50";

    public HelloData() {
        this.data = new HashMap<String, String>();
        this.data.put("line1_1",line1_1);
        this.data.put("line1_2",line1_2);
        this.data.put("line17_1",line17_1);
        this.data.put("line17_2",line17_2);
    }

    public static HelloData getInstance(){
        if (INSTANCE == null){
            INSTANCE = new HelloData();
        }
        return INSTANCE;
    }

    public HashMap<String, String> getData() {
        return data;
    }

    public  String getArrivings(String line) {
        System.out.println("DATA: " + data.get(line));
        return data.get(line);
    }
}