public class Calculator {
	private double result;
	private double num1;
	private double num2;
	private char operator; 
	
	public Calculator() {
		
	}
    public double getNum1(){
        return this.num1;
    }
	public void setNum1(double num1) {
		this.num1 = num1;
	}

    public double getNum2(){
        return this.num2;
    }
	public void setNum2(double num2) {
		this.num2 = num2;
	}
	public void setOperator(char input) {
		this.operator = input;
	}
	public void performOperation() {
		if( this.operator == '+') {
			result = (num1) + (num2);
		}
		if( this.operator == '-') {
			result = (num1) - (num2);
		}
        if(this.operator == '*'){
            result = (num1) * (num2);
		}
        
	}
	public void getResults() {
		System.out.println(result);
	}
}