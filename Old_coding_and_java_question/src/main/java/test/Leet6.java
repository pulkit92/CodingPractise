package test;

public class Leet6 {
	    public int reverse(int x) {
	        boolean b=false;
	        int s=0;
	        int p=-1;
	        if(x<0)
	        {b=true;
	        x=x*(-1);};
	        for(int i=x;i>0;i=i/10){
	            int r=i%10;
	            s=(int) ((Math.pow(10,p)*s)+r);
	            p++;
	        }
	        if(b)
	        {
	            return s*(-1);
	            
	        }
	        return s;
	        
	    }
	    
	    public static void main(String args[]) {
			Leet6 l = new Leet6();
			System.out.println(l.reverse(123));

		}
	}


