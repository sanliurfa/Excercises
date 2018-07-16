package overloadconstructor;

public class ThisConstructor {


	   private int rollNum;
	   ThisConstructor()
	   {
	      rollNum =100;
	   }
	   ThisConstructor(int rnum)
	   {
	      this();
	      /*this() is used for calling the default  
	       * constructor from parameterized constructor.
	       * It should always be the first statement 
	       * inside constructor body.
	       */
	      rollNum = rollNum+ rnum;
	   }
	   public int getRollNum() {
		  return rollNum;
	   }
	   public void setRollNum(int rollNum) {
		  this.rollNum = rollNum;
	   }
	   public static void main(String args[])
	   {
		   ThisConstructor obj = new ThisConstructor(12);
	       System.out.println(obj.getRollNum());
	    }
	}