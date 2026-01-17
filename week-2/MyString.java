
public class MyString {
    
    private char[] data;
    private int length;

    public MyString(String str) {
        if (str != null) {
            this.length = str.length();
            this.data = str.toCharArray();
        } else {
            this.length = 0;
            this.data = new char[0];
        }
    }

    public MyString concat(MyString otherStr) {
        if (otherStr == null) {
            return this;
        }

        String concatStr = this.toString() + otherStr.toString();
        MyString result = new MyString(concatStr);

        return result;
    }

    public int getLength() {
        return this.length;
    }

    @Override
    public String toString() {
        return new String(this.data);
    }


}
