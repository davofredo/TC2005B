package serialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CsvSerializer implements Iterable<String> {
    private static final String CELL_SEPARATOR = ",";
    private static final String LINE_SEPARATOR = "\r\n";

    private final List<Row> rows = new ArrayList<>();
    private Row headers;

    public void addRow(Row row) {
        rows.add(row);
    }

    public void setHeaders(Row row) {
        this.headers = row;
    }

    public List<Row> getRows() {
        return new ArrayList<>(rows);
    }

    public String serialize() {
        final StringBuilder sb = new StringBuilder();
        if(headers != null) sb.append(headers).append(LINE_SEPARATOR);
        rows.forEach(r -> sb.append(r).append(LINE_SEPARATOR));
        return sb.toString();
    }

    @Override
    public Iterator<String> iterator() {
        return new LineIterator();
    }

    /**
     * Iterates through CSV lines
     */
    private class LineIterator implements Iterator<String> {

        private Iterator<Row> rIterator;

        private LineIterator() {
            List<Row> rowList = new ArrayList<>();
            rowList.add(headers);
            rowList.addAll(rows);
            rIterator = rowList.iterator();
        }

        @Override
        public boolean hasNext() {
            return rIterator.hasNext();
        }

        @Override
        public String next() {
            return rIterator.next().toString();
        }
    }

    /**
     * Represents a CSV row
     */
    public static class Row {
        private static String serialize(Cell[] data) {
            StringBuilder sb = new StringBuilder();
            for(Cell cell : data) {
                sb.append(CELL_SEPARATOR).append(cell);
            }
            return sb.substring(CELL_SEPARATOR.length());
        }

        /**
         * Creates parses a Row from a serialized string
         * @param row Serialized string representing a row
         * @return a Row instance from the serialized string
         */
        static Row deserialize(String row) {
            boolean betweenQuotes = false;
            List<Cell> cellList = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < row.length(); i++) {
                char c = row.charAt(i);
                if(c == ',' && !betweenQuotes) {
                    cellList.add(new Cell(Cell.deserialize(sb.toString())));
                    sb = new StringBuilder();
                    continue;
                }
                if(c == '"') betweenQuotes = !betweenQuotes;
                sb.append(c);
            }
            // Add the last cell
            cellList.add(new Cell(Cell.deserialize(sb.toString())));
            return new Row(cellList.toArray(new Cell[0]));
        }

        Cell[] data;

        public Row(Object... data) {
            this.data = new Cell[data.length];
            for(int i = 0; i < data.length; i++)
                this.data[i] = new Cell(data[i]);
        }

        private Row(Cell[] data) {
            this.data = data;
        }

        /**
         * Returns a string representation of the cell indicated
         * @param index Cell index
         * @return <code>String.valueOf(data[index].getValue())</code> or <code>null</code>
         */
        String getValueAt(int index) {
            if(data[index].getValue() == null) return null;
            return String.valueOf(data[index].getValue());
        }

        public String toString() {
            return serialize(data);
        }
    }

    /**
     * Represents a CSV cell
     */
    private static class Cell {
        private static String serialize(Object value) {
            if(value == null) return "";
            String sval = String.valueOf(value);
            if(sval.contains(","))
                // Enclose in double quotes and escape internal quotes
                return String.format("\"%s\"", sval.replace("\"", "\"\""));
            // Return it unchanged
            return sval;
        }

        private static String deserialize(String value) {
            if(!value.contains(",") || !value.startsWith("\"") || !value.endsWith("\""))
                return value;
            String unquoted = value.substring(1, value.length() - 1);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < unquoted.length(); i++) {
                char c = unquoted.charAt(i);
                if(c == '"' && i < unquoted.length() - 1 && unquoted.charAt(i + 1) == '"')
                    i++;
                sb.append(c);
            }
            return sb.length() == 0 ? null : sb.toString();
        }

        private final Object value;

        private Cell(Object value) {
            this.value = value;
        }

        private Object getValue() {
            return value;
        }

        public String toString() {
            return serialize(value);
        }
    }

}
