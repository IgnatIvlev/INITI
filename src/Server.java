import java.util.Map;

public class Server {

    private static volatile Table table = new Table();

    public static void main(String[] args) {

    }

    public void addRow(String value1, String value2){
        table.addRow(value1, value2);
    }

    public void updateRow(Row row){
        table.updateRow(row.getId(), row);
    }

    public void deleteRow(String id){
        table.deleteRow(id);
    }

    public Map<String, Row> getRows(int start, int end){
        return table.getRowsInRange(start, end);
    }

    public Table sortTable(int columnIndex, SortingMethods methods){
        switch (methods){
            case method1 -> ...
            case method2 -> ...
            case method3 -> ...
        }
    }


    private class Sorter{
        /*Содержит методы сортировки таблицу*/
    }
}
