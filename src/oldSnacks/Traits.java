package oldSnacks;

public enum Traits{
    INTJ("strategic, analytical, and independent"),
    INTP("logical, intellectually curious, and deep thinking"),
    ENTJ("confident, strategic, and decisive"),
    ENTP("innovative, knowledgeable, and outspoken"),
    INFJ("conscientious, insightful, and organized"),
    INFP("empathetic, introspective, and imaginative"),
    ENFJ("charismatic, passionate, and empathetic"),
    ENFP("warm, outgoing, encouraging, and curious"),
    ISTJ("responsible, organized, and realistic"),
    ISFJ("quiet, considerate, and hardworking"),
    ESTJ("organized, assertive, and practical"),
    ESFJ("warm, cooperative, loyal, and conscientious"),
    ISTP("observant, adaptable, and problem solving"),
    ISFP("caring, passionate, and loyal"),
    ESTP("bold, pragmatic, energetic, and direct"),
    ESFP("enthusiastic, spontaneous, and sociable");

    private final String details;

    private Traits(String details) {
        this.details = details;
    }
    public String getDetails() {
        return details;
    }


}
