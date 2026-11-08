package simrskhanza;

public class LoginAttemptTrackerTest {
    public static void main(String[] args) {
        locksThreeConsecutiveFailuresForFiveMinutes();
        successBreaksTheFailureSequence();
        lockoutExpiresAfterFiveMinutes();
        remainingLockoutTracksElapsedTime();
        expiredLockoutResetsOnTheNextFailedAttempt();
        resetMarkerBreaksTheFailureSequence();
        System.out.println("LoginAttemptTrackerTest: 6 checks passed");
    }

    private static void locksThreeConsecutiveFailuresForFiveMinutes() {
        LoginAttemptTracker.AuditHistory history = history(0, "FAILURE", "FAILURE", "FAILURE");
        check(LoginAttemptTracker.remainingLockoutMillis(history) == 5 * 60_000L,
                "three consecutive failures must lock for five minutes");
    }

    private static void successBreaksTheFailureSequence() {
        LoginAttemptTracker.AuditHistory history = history(0, "FAILURE", "SUCCESS", "FAILURE");
        check(LoginAttemptTracker.remainingLockoutMillis(history) == 0,
                "a successful login must break the failure sequence");
    }

    private static void lockoutExpiresAfterFiveMinutes() {
        LoginAttemptTracker.AuditHistory history = history(300, "FAILURE", "FAILURE", "FAILURE");
        check(LoginAttemptTracker.remainingLockoutMillis(history) == 0,
                "lockout must expire after five minutes");
    }

    private static void remainingLockoutTracksElapsedTime() {
        LoginAttemptTracker.AuditHistory history = history(299, "FAILURE", "FAILURE", "FAILURE");
        check(LoginAttemptTracker.remainingLockoutMillis(history) == 1000L,
                "remaining lockout must decrease with elapsed time");
    }

    private static void expiredLockoutResetsOnTheNextFailedAttempt() {
        LoginAttemptTracker.AuditHistory history = history(300, "FAILURE", "FAILURE", "FAILURE");
        check(LoginAttemptTracker.shouldResetExpiredLockout(history),
                "a failed attempt after an expired lockout must start a new count");
    }

    private static void resetMarkerBreaksTheFailureSequence() {
        LoginAttemptTracker.AuditHistory history = history(0, "FAILURE", "RESET", "FAILURE");
        check(LoginAttemptTracker.remainingLockoutMillis(history) == 0,
                "the expired-lockout reset marker must break the failure sequence");
    }

    private static LoginAttemptTracker.AuditHistory history(long age, String... results) {
        return new LoginAttemptTracker.AuditHistory(results, age);
    }

    private static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }
}
