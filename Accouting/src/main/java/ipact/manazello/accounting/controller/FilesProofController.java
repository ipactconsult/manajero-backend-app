package ipact.manazello.accounting.controller;

import ipact.manazello.accounting.business.ibusiness.IFilesProofBusiness;
import ipact.manazello.accounting.model.FilesProof;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;


@CrossOrigin(origins = {"https://manazello-admin.netlify.app", "http://localhost:4200"})
@RestController
@RequestMapping("/filesproof")
public class FilesProofController {

    private final IFilesProofBusiness iFilesProofBusiness;

    public FilesProofController(IFilesProofBusiness iFilesProofBusiness) {
        this.iFilesProofBusiness = iFilesProofBusiness;
    }


    @PostMapping("/files/add")
    public String addPhoto(@RequestParam("title") String title,
                           @RequestParam("image") MultipartFile image, Model model)
            throws IOException {
        String id = iFilesProofBusiness.addFilesProof(title, image);
        return "redirect:/photos/filesproof" + id;
    }

    @GetMapping("/files/get/{id}")
    public String getPhoto(@PathVariable String id, Model model) {
        FilesProof filesProof = iFilesProofBusiness.getFilesProof(id);
        model.addAttribute("title", filesProof.getTitle());
        model.addAttribute("image",
                Base64.getEncoder().encodeToString(filesProof.getImage().getData()));
        return "photos";
    }

    @GetMapping("/filesproofs")
    public ResponseEntity<List<FilesProof>> getAllLines(){
        try {
            List<FilesProof> filesProof = iFilesProofBusiness.getAllFilesProof();

            if (filesProof.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(filesProof, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
