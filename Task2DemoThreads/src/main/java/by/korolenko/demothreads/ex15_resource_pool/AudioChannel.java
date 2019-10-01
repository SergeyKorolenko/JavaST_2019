package by.korolenko.demothreads.ex15_resource_pool;

public class AudioChannel {
    private int сhannelId;

    public AudioChannel(int id) {
        super();
        this.сhannelId = id;
    }

    public int getСhannelId() {
        return сhannelId;
    }

    public void setСhannelId(int id) {
        this.сhannelId = id;
    }

    public void using() {
        try {   // использование канала
            Thread.sleep(new java.util.Random().nextInt(500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
