package application.model;


import application.util.ConsoleColors;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Player {
    private String id;
    private String name;
    private String color;
    private Stack<Piece> stack1= new Stack<>();
    private Stack<Piece> stack2= new Stack<>();
    private Stack<Piece> stack3= new Stack<>();
    private List<Piece> pieceList;

    public Player(String id, String name, String color, int size) {
        this.id = id;
        this.name = name;
        this.color = color;
        List<Piece> pieceList = new ArrayList<>();
        
        for(int i=1; i<5; i++) {
        	stack1.push(new Piece(i,true,false,1));
        	stack2.push(new Piece(i,true,false, 2));
            stack3.push(new Piece(i,true,false, 3));
        }
       
     
        
        pieceList.add(stack1.peek());
        pieceList.add(stack2.peek());
        pieceList.add(stack3.peek());
        
        this.pieceList = pieceList;
    }

    public void printPlayerPieces(){
        System.out.println();
        System.out.print("Pieces of " + this.name + " are: ");
        for( Piece piece : pieceList)
            System.out.print( "\n"+piece.getVal()+" is External: "+piece.isExternal()+", is Internal: "+
        piece.isInternal()+" Stack number: "+ piece.getStack()+"\n");
        
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(id, player.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    public Stack<Piece> getStack(int i) {
    	if(i==1)
    		return stack1;
    	if(i==2)
    		return stack2;
    	if(i==3)
    		return stack3;
    	else
    		return  null;
    	
        
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Piece> getPieceList() {
        return pieceList;
    }

    public void setPieceList(List<Piece> pieceList) {
        this.pieceList = pieceList;
    }
}