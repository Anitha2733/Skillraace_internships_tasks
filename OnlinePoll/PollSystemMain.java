public class PollSystemMain {
    public static void main(String[] args) {
        CandidateDAO candidateDAO = new CandidateDAO();
        AdminService adminService = new AdminService(candidateDAO);
        // Example usage
        adminService.addCandidate("Mike Johnson", "Republican");

        var candidates = adminService.getAllCandidates();
        for (Candidate candidate : candidates) {
            System.out.println(candidate.getName() + " - " + candidate.getParty());
        }
    }
}
