import java.awt.*;

public class Application {
    public static Scheme[][] array_model;
    public static void main(String[] args)
    {
        array_model =
                new Scheme[][]{
                        {CreateGuard(1), CreateGuard(1), CreateGuard(1), CreateGuard(1), CreateLeader(1)},
                        {CreateNullElement(), CreateNullElement(), CreateNullElement(), CreateNullElement(), CreateNullElement()},
                        {CreateNullElement(), CreateNullElement(), CreateNullElement(), CreateNullElement(), CreateNullElement()},
                        {CreateNullElement(), CreateNullElement(), CreateNullElement(), CreateNullElement(), CreateNullElement()},
                        {CreateLeader(0), CreateGuard(0), CreateGuard(0), CreateGuard(0), CreateGuard(0)}

                };
        Work work = new Work();
        work.Create();
    }

    private static Scheme CreateNullElement() {
        return new Scheme(0,0,0,0, null);
    }

    private static Scheme CreateGuard(int i) {
        if (i == 1)
        {
            return new Scheme(0,0,0,0 , new Guard("guard", 1 , Color.yellow , Color.green)) ;
        }
        else
        {
            return new Scheme(0,0,0,0 , new Guard("guard",  2 , Color.green , Color.yellow));
        }
    }

    private static Scheme CreateLeader(int i) {
        if (i == 1)
        {
            return new Scheme(0,0,0,0 , new Leader("leader",  1 , Color.yellow , Color.black));
        }
        else
        {
            return new Scheme(0,0,0,0 ,  new Leader("leader",  2 , Color.green , Color.black));
        }
    }
}
