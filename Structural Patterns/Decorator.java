
interface NPC {

    public String desc();
}

class BasicNPC implements NPC {

    public String desc() {
        return (" Basic NPC");
    }
}

class ArmoredNPC implements NPC {

    final NPC npc;

    public ArmoredNPC(NPC npc) {
        this.npc = npc;
    }

    public String desc() {
        return (npc.desc() + " | with Armor");
    }
}

class OverpoweredNPC implements NPC {

    final NPC npc;

    public OverpoweredNPC(NPC npc) {
        this.npc = npc;
    }

    public String desc() {
        return (npc.desc() + " | with OverPower");
    }
}

class Decorator {

    public static void main(String[] jayesh) {
        NPC npc = new BasicNPC();
        System.out.println(npc.desc());
        npc = new ArmoredNPC(npc);
        System.out.println(npc.desc());
        npc = new OverpoweredNPC(npc);
        System.out.println(npc.desc());
    }
}
