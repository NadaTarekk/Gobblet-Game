package application.model;

public class Piece {
    private int val;
    private Boolean external;
    private Boolean internal;
    private int stack;
    private int row;
    private int col;

    

    public Piece(int val,Boolean external,Boolean internal, int stack ) {
        this.val = val;
        this.external = external;
        this.internal = internal;
        this.stack = stack;

    }

    public int getVal() {
        return val;
    }
    
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    
    public String getType() {
        if(external)
        	return "external";
        if(internal)
        	return "internal";
        else
        	return "";
    }
    
    public int getStack() {
        return stack;
    }
    
    public int setStack() {
        return stack;
    }


    public void setVal(int val) {
        this.val = val;
    }
    
    public void setRow(int row) {
        this.row = row;
    }
    
    public void setCol(int col) {
        this.col = col;
    }
    // Getter for External
    public Boolean isExternal() {
        return external;
    }

    // Setter for External
    public void setExternal(Boolean external) {
        this.external = external;
    }

    // Getter for Internal
    public Boolean isInternal() {
        return internal;
    }

    // Setter for Internal
    public void setInternal(Boolean internal) {
        this.internal = internal;
    }
}