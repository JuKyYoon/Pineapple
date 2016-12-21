/**
 * 2016-11-21
 * Account Management activity
 * @author jk
 * @version 1.0
 */

package pineapple.iq_quest;

/**
 * The type You.
 */
public class You{
    private String age;
    private String name;
    private int ok=0;
    private int no=0;
    private int num=0;

    /**
     * Sets no.
     *
     * @param no the no
     */
    public void setNo(int no) {this.no += no;}

    /**
     * Sets ok.
     *
     * @param ok the ok
     */
    public void setOk(int ok) {this.ok += ok;}

    /**
     * Gets age.
     *
     * @return the age
     */
    public String getAge() {return age;}

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {return name;}

    /**
     * Gets num.
     *
     * @return the num
     */
    public int getNum() {return num;}

    /**
     * Get ok int.
     *
     * @return the int
     */
    public int getOk(){return ok;}

    /**
     * Get no int.
     *
     * @return the int
     */
    public int getNo(){return no;}

    /**
     * Instantiates a new You.
     *
     * @param name the name
     * @param age  the age
     * @param num  the num
     */
    public You(String name, String age, int num){
        this.name = name;
        this.age = age;
        this.num = num;
    }
}
