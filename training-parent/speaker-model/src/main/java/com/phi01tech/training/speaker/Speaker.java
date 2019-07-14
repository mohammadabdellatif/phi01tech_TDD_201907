package com.phi01tech.training.speaker;

import java.util.Arrays;
import java.util.List;

public class Speaker {

    public String firstName;
    public String lastName;
    public String email;
    public int exp;
    public boolean hasBlog;
    public String blog;
    public WebBrowser browser;
    public List<String> certifications;
    public String employer;
    public int registrationFee;
    public List<Session> session;

    public int register(Repository repository) {
        Integer speakerId = null;
        boolean good = false;
        boolean appr = false;
        List<String> ot = Arrays.asList("Cobol", "Punch Cards", "Commodore", "VBScript");

        List<String> domains = Arrays.asList("aol.com", "hotmail.com", "prodigy.com", "CompuServe.com");

        if (!IsNullOrWhiteSpace(firstName)) {
            if (!IsNullOrWhiteSpace(lastName)) {


                if (!IsNullOrWhiteSpace(email)) {
                    List<String> emps = Arrays.asList("Microsoft", "Google", "Fog Creek Software", "37Signals");

                    good = ((exp > 10 || hasBlog || certifications.size() > 3 || emps.contains(employer)));


                    if (!good) {
                        String emailDomain = email.split("@")[1];

                        if (!domains.contains(emailDomain) && (!(browser.getName() == WebBrowser.BrowserName.InternetExplorer && browser.getMajorVersion() < 9))) {
                            good = true;
                        }
                    }

                    if (good) {
                        if (session.size() != 0) {
                            for (Session session : session) {

                                for (String tech : ot) {
                                    if (session.getTitle().contains(tech) || session.getDescription().contains(tech)) {
                                        session.setApproved(false);
                                        break;
                                    } else {
                                        session.setApproved(true);
                                        appr = true;
                                    }
                                }
                            }
                        } else {
                            throw new IllegalArgumentException("Can't register speaker with no sessions to present.");
                        }

                        if (appr) {
                            if (exp <= 1) {
                                registrationFee = 500;
                            } else if (exp >= 2 && exp <= 3) {
                                registrationFee = 250;
                            } else if (exp >= 4 && exp <= 5) {
                                registrationFee = 100;
                            } else if (exp >= 6 && exp <= 9) {
                                registrationFee = 50;
                            } else {
                                registrationFee = 0;
                            }


                            try {
                                speakerId = repository.saveSpeaker(this);
                            } catch (Exception e) {
                            }
                        } else {
                            throw new NoSessionsApprovedException("No sessions approved.");
                        }
                    } else {
                        throw new SpeakerDoesntMeetRequirementsException("Speaker doesn't meet our abitrary and capricious standards.");
                    }

                } else {
                    throw new IllegalArgumentException("email is required.");
                }
            } else {
                throw new IllegalArgumentException("Last name is required.");
            }
        } else {
            throw new IllegalArgumentException("First Name is required");
        }

        return speakerId;
    }

    private boolean IsNullOrWhiteSpace(String value) {
        return value == null || value.trim().equals("");
    }

    public class SpeakerDoesntMeetRequirementsException extends RuntimeException {
        public SpeakerDoesntMeetRequirementsException(String message) {
            super(message);
        }

        public SpeakerDoesntMeetRequirementsException(String format, Object... args) {
            super(String.format(format, args));
        }
    }

    public class NoSessionsApprovedException extends RuntimeException {
        public NoSessionsApprovedException(String message) {
            super(message);
        }
    }
}
