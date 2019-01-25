public class Main
{
    public static void main(String[] args)
    {
        String csvFile = "./src/attributes.csv";
        ReadCSV myRead = new ReadCSV(csvFile);
        ProduceJSON myJson = new ProduceJSON(myRead.getObjList());

        //test
        myJson.printJSON();
    }
}