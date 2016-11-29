package pineapple.iq_quest;

/**
 * Created by jk on 2016. 11. 21..
 */

public class You{
    private int age = 0;
    private String name;
    private int ok=0;
    private int no=0;
    private int num=0;

    public void setNo(int no) {this.no += no;}

    public void setOk(int ok) {this.ok += ok;}

    public int getAge() {return age;}

    public String getName() {return name;}

    public int getNum() {return num;}

    public int getOk(){return ok;}
    public int getNo(){return no;}

    public You(String name, int age, int num){
        this.name = name;
        this.age = age;
        this.num = num;
    }
}
