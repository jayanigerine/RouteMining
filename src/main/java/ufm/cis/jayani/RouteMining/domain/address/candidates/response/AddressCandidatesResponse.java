package ufm.cis.jayani.RouteMining.domain.address.candidates.response;

public class AddressCandidatesResponse {
	public Candidates[] candidates;

	public SpatialReference spatialReference;

	public Candidates[] getCandidates() {
		return candidates;
	}

	public void setCandidates(Candidates[] candidates) {
		this.candidates = candidates;
	}

	public SpatialReference getSpatialReference() {
		return spatialReference;
	}

	public void setSpatialReference(SpatialReference spatialReference) {
		this.spatialReference = spatialReference;
	}

	@Override
	public String toString() {
		return "ClassPojo [candidates = " + candidates + ", spatialReference = " + spatialReference + "]";
	}
}