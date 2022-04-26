package w3r.runsharing.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import w3r.runsharing.entity.RunRecap;
import w3r.runsharing.repository.RunRecapRepository;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Optional;

@RestController
public class RunController {

    private final RunRecapRepository runRecapRepository;

    @Autowired
    public RunController(
            final RunRecapRepository runRecapRepository
    ) {
        this.runRecapRepository = runRecapRepository;
    }

    @PostMapping(value = "/submitRun")
    @Transactional
    public ResponseEntity<Void> postRun(
            final @RequestBody String runJson
    ) {
        Gson gson = new GsonBuilder().create();
        RunRecap recap = gson.fromJson(runJson, RunRecap.class);
        recap.setPermanent(false);
        recap.setUploadedAt(Instant.now());
        runRecapRepository.save(recap);
        return ResponseEntity.ok().build();
    }

    @RequestMapping("/run/{runId}")
    public ResponseEntity<Optional<RunRecap>> getRun(
            final @PathVariable Long runId
    ) {
        Optional<RunRecap> result = runRecapRepository.findById(runId);
        return ResponseEntity.ok(result);
    }

    @RequestMapping("runs")
    public ResponseEntity<Page<RunRecap>> getRuns(
            final @RequestParam(name = "hostFilter", required = false) String hostFilter,
            final @RequestParam(name = "characterFilter", required = false) String characterFilter,
            final Pageable pageable
    ) {
        Page<RunRecap> result = runRecapRepository.findByHostAndCharacterChosen(hostFilter, characterFilter, pageable);
        return ResponseEntity.ok(result);
    }
}
