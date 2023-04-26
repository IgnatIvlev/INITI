import java.util.Random;

public class Row {
    String id;
    String column1, column2;

    //Конструктор строки
    public Row(String id, String column1, String column2) {
        this.id = id;
        this.column1 = column1;
        this.column2 = column2;
    }

    //Геттеры и сеттеры для ID  и столбцов
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }

    public String getColumn2() {
        return column2;
    }

    public void setColumn2(String column2) {
        this.column2 = column2;
    }

    //Метод вывода строки
    public String getRow(){
        return " --- " + column1 + " --- " + column2;
    }

    //Переопределяем метод equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Row)) return false;
        Row row = (Row) o;

        if (id.equals(row.getId())) return false;
        if (column1 != null ? !column1.equals(row.column1) : row.column1 != null) return false;
        if (column2 != null ? !column2.equals(row.column2) : row.column2 != null) return false;

        return true;
    }
}
