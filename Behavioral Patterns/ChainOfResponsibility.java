
interface Approver {

    public void setApprover(Approver a);

    public String approve(int days);
}

class Supervisor implements Approver {

    Approver approver;

    public void setApprover(Approver a) {
        this.approver = a;
    }

    public String approve(int days) {
        if (days <= 5) {
            return "Approved";
        }
        return approver.approve(days);
    }
}

class Manager implements Approver {

    Approver approver;

    public void setApprover(Approver a) {
        this.approver = a;
    }

    public String approve(int days) {
        if (days <= 10) {
            return "Approved";
        }
        return "Denied";
    }
}

class ChainOfResponsibility {

    public static void main(String[] jayesh) {
        Approver supervisor = new Supervisor();
        Approver manager = new Manager();
        supervisor.setApprover(manager);
        System.out.println(supervisor.approve(5));
        System.out.println(supervisor.approve(8));
        System.out.println(supervisor.approve(50));

    }
}
