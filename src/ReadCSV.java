import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadCSV {

    private String csvFile;
    private ArrayList<String[]> dataList;
    private int propSize;

    private ArrayList<String[]> dataObj;



    public ReadCSV(String _csvFile)
    {
        this.csvFile = _csvFile;
        this.dataList = convertCSVtoList();
        this.propSize = this.dataList.size();
        this.dataObj = this.createObj();
    }

    public ArrayList<String[]> getObjList()
    {
        return this.dataObj;
    }

    private ArrayList<String[]> createObj()
    {
        ArrayList<String[]> listOBJ = new ArrayList<String[]>();

        String[] objs = new String[this.propSize];
        for(int i=0;i<objs.length;i++)
            objs[i]= "";

        for (int i =0; i< this.propSize; i ++)
        {
            String[] temp = dataList.get(i);
            for(int j=0; j<temp.length; j++)
            {
                objs[j] += temp[j];
                objs[j] += ";";
            }
        }

        for(int i=0; i<objs.length; i++)
        {
            listOBJ.add(objs[i].split(";"));
        }

        return listOBJ;
    }

    private ArrayList<String[]> convertCSVtoList()
    {
        BufferedReader br = null;
        String line = "";
        String[] name;
        ArrayList<String[]> temps = new ArrayList<String[]>();

        try {
            br = new BufferedReader(new FileReader(csvFile));
            while((line = br.readLine()) != null)
            {
                name = line.split(";");
                temps.add(name);
            }

        } catch (FileNotFoundException ef) {
            ef.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return temps;
    }




}
