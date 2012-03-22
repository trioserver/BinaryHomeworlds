public enum Color {
    BLUE(0),RED(1),YELLOW(2),GREEN(3);
    
    public int code;
    
    private Color(int c) {
      code = c;
    }
    
    public int getCode() {
      return code;
    }
}
