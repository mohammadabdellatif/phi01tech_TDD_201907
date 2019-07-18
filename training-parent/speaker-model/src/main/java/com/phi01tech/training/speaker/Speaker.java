package com.phi01tech.training.speaker;

import java.util.Arrays;
import java.util.List;

public class Speaker {

    private static final List<String> UNAPPROVED_SCRIPTING_LANGUAGES = Arrays.asList("Cobol", "Punch Cards", "Commodore", "VBScript");
    private static final List<String> DOMAINS = Arrays.asList("aol.com", "hotmail.com", "prodigy.com", "CompuServe.com");
    private static final List<String> EMPLOYERS = Arrays.asList("Microsoft", "Google", "Fog Creek Software", "37Signals");
    private static final int DEFAULT_FEE = 0;

    public String firstName;
    public String lastName;
    public String email;
    public String employer;

    public int experience;
    public boolean hasBlog;
    public List<String> certifications;
    public String blog;

    public int registrationFee = DEFAULT_FEE;
    public WebBrowser browser;
    public List<Session> session;

    public int register(Repository repository) {
        validateSpeakerStatus();
        updateRegistrationFee();
        return repository.saveSpeaker(this);
    }

    private void updateRegistrationFee() {
        if (experience <= 1) {
            registrationFee = 500;
        } else if (experience >= 2 && experience <= 3) {
            registrationFee = 250;
        } else if (experience >= 4 && experience <= 5) {
            registrationFee = 100;
        } else if (experience >= 6 && experience <= 9) {
            registrationFee = 50;
        }
    }

    private void validateSpeakerStatus() {
        validateContactFields();
        validateSpeakerRequirements();
        validateSessions();
    }

    private void validateSpeakerRequirements() {
        if (!doesSpeakerMeetRequirements())
            throw new SpeakerDoesntMeetRequirementsException("Speaker doesn't meet our abitrary and capricious standards.");
    }

    private void validateSessions() {
        if (!hasSessions())
            throw new IllegalArgumentException("Can't register speaker with no sessions to present.");
        if (!hasApprovedSessions())
            throw new NoSessionsApprovedException("No sessions approved.");
    }

    private void validateContactFields() {
        if (isNullOrWhiteSpace(firstName))
            throw new IllegalArgumentException("First Name is required");
        if (isNullOrWhiteSpace(lastName))
            throw new IllegalArgumentException("Last name is required.");
        if (isNullOrWhiteSpace(email))
            throw new IllegalArgumentException("email is required.");
    }

    private boolean hasApprovedSessions() {
        boolean approved = false;
        for (Session session : session) {
            updateSessionApproval(session);
            if (session.isApproved())
                approved = true;
        }
        return approved;
    }

    private void updateSessionApproval(Session session) {
        session.setApproved(true);
        for (String tech : UNAPPROVED_SCRIPTING_LANGUAGES) {
            if (session.getTitle().contains(tech) || session.getDescription().contains(tech)) {
                session.setApproved(false);
                return;
            }
        }
    }

    private boolean hasSessions() {
        return session.size() != 0;
    }

    private boolean isKnownDomain() {
        String emailDomain = email.split("@")[1];
        return DOMAINS.contains(emailDomain);
    }

    private boolean isOutdatedIEBrowser() {
        return browser.getName() == WebBrowser.BrowserName.InternetExplorer && browser.getMajorVersion() < 9;
    }

    private boolean doesSpeakerMeetRequirements() {
        if (isExperienced() || isKnownEmployer() || (!isKnownDomain() && !isOutdatedIEBrowser())) {
            return true;
        }
        return false;
    }

    private boolean isKnownEmployer() {
        return EMPLOYERS.contains(employer);
    }

    private boolean isExperienced() {
        return experience > 10 || hasBlog || certifications.size() > 3;
    }

    private boolean isNullOrWhiteSpace(String value) {
        return value == null || value.trim().equals("");
    }

    public class SpeakerDoesntMeetRequirementsException extends RuntimeException {
        public SpeakerDoesntMeetRequirementsException(String message) {
            super(message);
        }

    }

    public class NoSessionsApprovedException extends RuntimeException {
        public NoSessionsApprovedException(String message) {
            super(message);
        }
    }
}
