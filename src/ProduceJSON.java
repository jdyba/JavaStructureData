import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProduceJSON {


    private ArrayList<HashMap<String, String>> dataMap;
    private List<JSONObject> jsonObj;


    public ProduceJSON (ArrayList<String[]> temp)
    {
        this.dataMap = this.writeHashmap(temp);
        this.jsonObj = this.writeListJSON();
    }


    private ArrayList<HashMap<String, String>> writeHashmap(ArrayList<String[]> temp1)
    {
        final int propertyName = 0;
        final int startData = 1;

        ArrayList<HashMap<String, String>> tempHashmap = new ArrayList<HashMap<String, String>>();

        String[] property = temp1.get(propertyName);

        for(int i = startData; i<temp1.size(); i++)
        {
            HashMap<String, String> tempData = new HashMap<String, String>();
            String[] obj = temp1.get(i);
            for(int j=0; j<obj.length; j++)
            {
                tempData.put(property[j], obj[j]);
            }
            tempHashmap.add(tempData);
        }

        return tempHashmap;
    }


    private List<JSONObject> writeListJSON ()
    {
        List<JSONObject> tempJson = new ArrayList<JSONObject>();

        for(HashMap<String, String> data : this.dataMap)
        {
            JSONObject obj = new JSONObject(data);
            tempJson.add(obj);
        }

        return tempJson;
    }


    public void printJSON ()
    {
        this.jsonObj.forEach( e-> {
            System.out.println(e.toString());
        });
    }






}
