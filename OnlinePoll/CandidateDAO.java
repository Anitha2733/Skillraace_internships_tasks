import java.util.ArrayList;
import java.util.List;

public class CandidateDAO {
    private List<Candidate> candidates;

    public CandidateDAO() {
        this.candidates = new ArrayList<>();
        // Initialize with some dummy data
        candidates.add(new Candidate(1, "John Doe", "Independent"));
        candidates.add(new Candidate(2, "Jane Smith", "Democratic"));
    }

    public List<Candidate> getAllCandidates() {
        return candidates;
    }

    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
    }

    public void deleteCandidate(int id) {
        candidates.removeIf(c -> c.getId() == id);
    }

    // Other CRUD operations as needed
}
