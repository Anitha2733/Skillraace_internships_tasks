import java.util.List;

public class AdminService {
    private CandidateDAO candidateDAO;

    public AdminService(CandidateDAO candidateDAO) {
        this.candidateDAO = candidateDAO;
    }

    public void addCandidate(String name, String party) {
        int newId = candidateDAO.getAllCandidates().size() + 1;
        Candidate newCandidate = new Candidate(newId, name, party);
        candidateDAO.addCandidate(newCandidate);
    }

    public void deleteCandidate(int id) {
        candidateDAO.deleteCandidate(id);
    }

    public List<Candidate> getAllCandidates() {
        return candidateDAO.getAllCandidates();
    }

    // Other admin operations
}
