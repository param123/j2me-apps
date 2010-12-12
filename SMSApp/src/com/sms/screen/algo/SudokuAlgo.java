/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen.algo;

/**
 *
 * @author PKumar
 */
import java.util.Vector;
import java.util.Random;

public class SudokuAlgo {

	private Cell cellBrick[][] = new Cell[9][9];
	private Region region[] = new Region[9];
	private Column column[] = new Column[9];
	private Row row[] = new Row[9];

	private int VALUES[] = { 3, 5, 4, 1, 8, 6, 2, 7, 9 };

	private Vector NUMBERS = new Vector();
	private Vector CHECKED_NUMBERS = new Vector();

	private Random randomGenerator = new Random(9);
	private int currentRandomNumber = 0;
	private Integer indexNumber = null;

        public SudokuAlgo(){
            init();
            reshuffel(generateRandomNumber());
            reshuffel(generateRandomNumber());
            create();
            randomFill();
        }

	
	public int generateRandomNumber(){
		long time = System.currentTimeMillis();
		int reminder = (int)(time % 10);
		if(reminder==9){
			reminder--;
		}else if(reminder ==0){
			reminder++;
		}
                return reminder;
	}

        private void reshuffel(int changeNumber){
               int temp = VALUES[changeNumber];
		VALUES[changeNumber] = VALUES[0];
		VALUES[0] = temp;
           }

        public void randomFill(){
           
            for(int i=0;i<9;i++){
                int ranNums[] = new int[4];
                for(int j=0;j<4;j++){
                    int ranNum = randomGenerator.nextInt(9);
                    if(!checkIfExist(ranNums, ranNum)){
                        ranNums[j] = ranNum;
                        row[i].getCell(new int[]{ranNum}).changeUserValueToReal();
                    }else{
                        j--;
                    }
                }
                
            }
          }

        private boolean checkIfExist(int[] nums, int checkMe){
            for (int i = 0; i < nums.length; i++) {
                if(checkMe == nums[i]){
                    return true;
                }
             }
            return false;
        }

        public Region getRegion(int regNo){
            return region[regNo];
        }

         public Row getRow(int rowNo){
            return row[rowNo];
        }

	private void print(){
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print("|"+cellBrick[i][j].toString());
			}
			System.out.println();
			System.out.println(" - - - - - - - - - ");
		}
	}

	public void init() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				cellBrick[i][j] = new Cell(i, j);
			}
		}
		for (int i = 0; i < 9; i++) {
			region[i] = new Region(i);
			row[i] = new Row(i);
			column[i] = new Column(i);
		}
	}

	private void create() {

		for (int i = 0; i < 9; i++) {
			generateNUMBERS();
			for (int j = 0; j < 9; j++) {
				while (true) {
				try{
					getRandomNumber();
				}catch(Exception e){
					print();
					throw new RuntimeException(e.getMessage());
				}
					if (cellBrick[i][j].update(currentRandomNumber)) {
						cellBrick[i][j].commit();
						break;
					} else {
                       if(backtrack(cellBrick[i][j])){
                    	   break;
                       }
					}
				}
				CHECKED_NUMBERS.removeElement(indexNumber);
                                for(int a=0;a<CHECKED_NUMBERS.size();a++){
				NUMBERS.addElement(CHECKED_NUMBERS.elementAt(a));
                                }
				CHECKED_NUMBERS.removeAllElements();
				indexNumber = null;
			}
		}
	}

	private boolean backtrack(Cell cell) {
            if(cell.colNum>0){
            	for(int i=cell.colNum-1;i>-1;i--){
	            	Cell previousCell = cellBrick[cell.rowNum][i];
	            	int value = previousCell.realValue;
	            	if (previousCell.update(currentRandomNumber)) {
	            		previousCell.commit();
	            		if (cell.update(value)) {
	                		cell.commit();
	                		return true;
	    				}else{
	    					previousCell.changeValueDirectly(value);
	    				}
					}
            	}
            }
          return false;
	}

	private void generateNUMBERS() {
		NUMBERS.removeAllElements();
		for (int i = 0; i < 9; i++) {
			NUMBERS.addElement(Integer.valueOf(String.valueOf(VALUES[i])));
		}
	}

	private int getRandomNumber() {
		int index = randomGenerator.nextInt(NUMBERS.size());
		indexNumber = (Integer) NUMBERS.elementAt(index);
		currentRandomNumber = indexNumber.intValue();
		NUMBERS.removeElementAt(index);
		CHECKED_NUMBERS.addElement(indexNumber);
		return currentRandomNumber;
	}

	private interface CellNotifier {
		public boolean validateCell(Cell cell);
		public void assignCell();
                public Cell getCell(int[] cellAddress);
	}

	public class Region implements CellNotifier {
		int regionNumber = -1;
		private Cell regCells[][] = new Cell[3][3];
		private Region(int regionNumber) {
			this.regionNumber = regionNumber;
			assignCell();
		}

             
		public boolean validateCell(Cell cell) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (regCells[i][j] != cell
							&& regCells[i][j].realValue == cell.tempValue) {
						return false;
					}
				}
			}
			return true;
		}

		public void assignCell() {
			int minRow = 0;
			int maxRow = 0;
			int minCol = 0;
			int maxCol = 0;
			switch (regionNumber) {
			case 0:
				minRow = 0;
				maxRow = 2;
				minCol = 0;
				maxCol = 2;
				break;
			case 1:
				minRow = 0;
				maxRow = 2;
				minCol = 3;
				maxCol = 5;
				break;
			case 2:
				minRow = 0;
				maxRow = 2;
				minCol = 6;
				maxCol = 8;
				break;
			case 3:
				minRow = 3;
				maxRow = 5;
				minCol = 0;
				maxCol = 2;
				break;
			case 4:
				minRow = 3;
				maxRow = 5;
				minCol = 3;
				maxCol = 5;
				break;
			case 5:
				minRow = 3;
				maxRow = 5;
				minCol = 6;
				maxCol = 8;
				break;
			case 6:
				minRow = 6;
				maxRow = 8;
				minCol = 0;
				maxCol = 2;
				break;
			case 7:
				minRow = 6;
				maxRow = 8;
				minCol = 3;
				maxCol = 5;
				break;
			case 8:
				minRow = 6;
				maxRow = 8;
				minCol = 6;
				maxCol = 8;
				break;
			default:
				throw new RuntimeException("Illegal reagion " + regionNumber);
			}

			for (int i = minRow; i <= maxRow; i++) {
				for (int j = minCol; j <= maxCol; j++) {
					regCells[i - minRow][j - minCol] = cellBrick[i][j];
					regCells[i - minRow][j - minCol].registerParent(this);
				}
			}

		}

               

            public Cell getCell(int[] cellAddress) {
               return regCells[cellAddress[0]][cellAddress[1]];
            }

            public void setCell(int[] cellAddress, int value) {
               getCell(cellAddress).changeValueDirectly(value);
            }

	}

	public class Row implements CellNotifier {

		int rowNum = -1;
		private Cell rowCells[] = new Cell[9];

		private Row(int rowNum) {
			this.rowNum = rowNum;
			assignCell();
		}

		public void assignCell() {
			for (int i = 0; i < 9; i++) {
				rowCells[i] = cellBrick[rowNum][i];
				rowCells[i].registerParent(this);
			}
		}

		public boolean validateCell(Cell cell) {
			for (int i = 0; i < 9; i++) {
				if (rowCells[i] != cell
						&& rowCells[i].realValue == cell.tempValue) {
					return false;
				}
			}
			return true;
		}

        public Cell getCell(int[] cellAddress) {
            return rowCells[cellAddress[0]];
        }

        public void setCell(int[] cellAddress, int value) {
               getCell(cellAddress).changeValueDirectly(value);
            }

	}

	private class Column implements CellNotifier {
		int colNum = -1;
		private Cell colCells[] = new Cell[9];

		private Column(int colNum) {
			this.colNum = colNum;
			assignCell();
		}

		public void assignCell() {
			for (int i = 0; i < 9; i++) {
				colCells[i] = cellBrick[i][colNum];
				colCells[i].registerParent(this);
			}

		}

		public boolean validateCell(Cell cell) {
			for (int i = 0; i < 9; i++) {
				if (colCells[i] != cell
						&& colCells[i].realValue == cell.tempValue) {
					return false;
				}
			}
			return true;
		}

        public Cell getCell(int[] cellAddress) {
           return colCells[cellAddress[0]];
        }

        public void setCell(int[] cellAddress, int value) {
               getCell(cellAddress).changeValueDirectly(value);
            }

	}

	public class Cell {

		public int colNum = -1;
		public int rowNum = -1;

		private int realValue = -1;
		private int tempValue = -1;
                private int userValue = -1;

		private Vector parent = new Vector();

		private Cell(int rowNum, int colNum) {
			this.colNum = colNum;
			this.rowNum = rowNum;
		}

		private void registerParent(CellNotifier cn) {
			parent.addElement(cn);
		}

		private boolean update(int value) {
			tempValue = value;
			for (int i=0;i<parent.size();i++) {
				CellNotifier cellParent = (CellNotifier) parent.elementAt(i);
				if (!cellParent.validateCell(this)) {
					return false;
				}
			}

			return true;
		}

		private void changeValueDirectly(int value){
			realValue = value;
		}

		public void commit() {
			realValue = tempValue;
		}

                public void changeUserValueToReal(){
                    userValue = realValue;
                }

		public String toString(){
			return userValue==-1?"":String.valueOf(userValue);
		}

                private boolean userAndActualMatch(){
                    return userValue == realValue;
                }

	}

        public boolean check(){
           for(int i=0;i<9;i++){
              for(int j=0;j<9;j++){
                 if(!cellBrick[i][j].userAndActualMatch()){
                     return false;
                 }
              }
           }
            return true;
        }

}

