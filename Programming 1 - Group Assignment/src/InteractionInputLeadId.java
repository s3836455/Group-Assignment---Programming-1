public class InteractionInputLeadId {

    public String interactionInputLeadId() {

        String leadId;
        LeadIdCheck input = new LeadIdCheck();

        leadId = "lead_" + String.format("%03d", input.leadIdCheck());

        System.out.println("Interacton's associated Lead's ID: " + leadId);

        return leadId;
    }
}
