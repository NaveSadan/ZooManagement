import java.util.ArrayList;

public class ZooManager extends Creature {
    private String addressM;
    private String emailM;
    private ArrayList<ZooKeeper> zooKeepersM;

    //c'tors
    public ZooManager(String name, String id) {
        super(name,id);
        setAddressM("David38");
        setEmailM("cdDavid@cd");
        setZooKeepersM(new ArrayList<ZooKeeper>());
    }

    public ZooManager (String name, String id, String addressM, String emailM,ArrayList<ZooKeeper> zooKeepersM) {
        super(name,id);
        setAddressM(addressM);
        setEmailM(emailM);
        setZooKeepersM(zooKeepersM);
    }

    // Gets & Sets
    @Override
    public void setName(String name) {
        if (name.length() == 8)
            this.name = name;
        else
            this.name = "MANAGER";
    }
    @Override
    public void setId (String id) {
        if (id.length() == 9 && id.charAt(0) != 'a' && id.charAt(8) != 'a') {
            int cnt = 0;
            for (int i=1; i<8; i++) {
                if (id.charAt(i) == 'a')
                    cnt++;
            }
            if (cnt > 0)
                this.id = id;
        }
        else
            this.id = "BAbcacbAB";
    }

    public String getAddressM() {
        return addressM;
    }
    public void setAddressM(String addressM) {
        int sum = 0, cnt =0;
        for (int i=0; i<addressM.length(); i++) {
            if ((addressM.charAt(i) >= '0' && addressM.charAt(i) <= '9') ||
                    (addressM.toLowerCase().charAt(i) >= 'a' && addressM.toLowerCase().charAt(i) <= 'z')) {
                cnt++;
            }
        }
        if (cnt == addressM.length()) {
            for (int i=0; i<addressM.length(); i++) {
                if (addressM.charAt(i) >= '0' && addressM.charAt(i) <= '9') {
                    sum += Integer.valueOf((addressM.charAt(i)+""));
                }
            }
        }
        if (sum > 5)
            this.addressM = addressM;
        else
            this.addressM = "David38";
    }

    public String getEmailM() {
        return emailM;
    }
    public void setEmailM (String emailM) {
        if (emailM.length() == 10) {
            if (emailM.charAt(0) == emailM.charAt(emailM.length()-2) &&
                    emailM.charAt(1) == emailM.charAt(emailM.length()-1)) {
                this.emailM = emailM;
            }
        }
        else
            this.emailM = "cdDavid@cd";
    }

    public ArrayList<ZooKeeper> getZooKeepersM() {
        return zooKeepersM;
    }
    public void setZooKeepersM(ArrayList<ZooKeeper> zooKeepersM) {
        this.zooKeepersM = zooKeepersM;
    }







    //Methods
    @Override
    public String toString () {
        String str = "ZooManager; "+super.toString()+ ", Address= "+ addressM+ ", Email= "+ emailM+ "\nZooKeepers List: \n";
        for (ZooKeeper zooKeeper : zooKeepersM)
            str += zooKeeper + "\n";
        return str;
    }

    public void changeAddress(String newAddress) {
        setAddressM(newAddress);
    }
    @Override
    public boolean equals(Object o) {
        return (o!=null)&&(o instanceof ZooManager)&&(((ZooManager)o).name.equals(this.name)) && (((ZooManager)o).id.equals(this.id)) &&
                (((ZooManager)o).addressM.equals(this.addressM)) && (((ZooManager)o).emailM.equals(this.emailM)) &&
                (((ZooManager)o).zooKeepersM.equals(this.zooKeepersM));
    }

    public void addZooKeeper (ZooKeeper zooKeeper) {
        zooKeepersM.add(zooKeeper);
    }

    public int calculateCaloriesBurned() {
        return  5*5000;
    }
}
