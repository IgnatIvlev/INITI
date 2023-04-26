import java.util.*;

public class Table {
    private Map<String, Row> table;
    private List<String> idList;
    private int rowCount;

    /*
    * В моей реализации добавлен idList который содержит порядок добавления ID чтобы было просто
    * отсортировать по порядку ID. Это не корректно. Необходимо добавить методы сортировки с использованием
    * компараторов. К сожалению, я не имею достаточного опыта, чтобы это реализовать.
    * */
    //Метод добавления новой строки в таблицу
    public void addRow(String value1, String value2){
        String id = generateID(6);
        while(true){
            if(!idList.contains(id)){
                idList.add(id);
                Collections.sort(idList);
                table.put(id ,new Row(id, value1, value2));
                break;
            }
            else{
                id = generateID(6);
            }
        }

    }

    //Метод обновления данных строки в таблице
    public void updateRow(String id, Row updatedRow){
        if(table.containsKey(id)){
            table.remove(id);
            table.put(id, updatedRow);
        }
        else{
            System.out.println("Incorrect ID");
        }
    }

    //Метод удаления данных строки в таблиц
    public void deleteRow(String id){
        if(table.containsKey(id)) {
            table.remove(id);
            idList.remove(id);
        }
        else{
            System.out.println("Incorrect ID");
        }
    }

    //Метод получения строки из таблицы
    public void getRow(String id){
        if(table.containsKey(id)) {
            System.out.println(id + table.get(id).getRow());
        }
        else{
            System.out.println("Incorrect ID");
        }
    }

    //Метод получения части таблицы в заданом диапазоне
    public Map<String,Row> getRowsInRange(int start, int end) {
        Map<String, Row> rowsInRange = new HashMap<>();
        if(end < getRowCount()) {
            for (int i = start; i < start + end; i++) {
                rowsInRange.put(idList.get(i), table.get(idList.get(i)));
            }
        }
        return rowsInRange;
    }

    //Методы фильтрации данных. Методов может быть несколько.
    public Map<String,Row> filter(String value){
        return new HashMap<>();
    }

    //Метод получения размера таблицы
    public int getRowCount(){
        return table.size();
    }

    //Удаление всех данных из таблицы
    public void clear(){
        idList.clear();
        table.clear();
    }
    //Метод генераци ID. Я решил сделать его поинтереснее)
    private static String generateID(int length) {
        String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(charSet.length());
            char randomChar = charSet.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }
}