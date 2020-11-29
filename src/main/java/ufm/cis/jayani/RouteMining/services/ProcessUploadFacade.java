package ufm.cis.jayani.RouteMining.services;

import org.springframework.web.multipart.MultipartFile;

public interface ProcessUploadFacade {
	String processFileUpload(MultipartFile file);
}
