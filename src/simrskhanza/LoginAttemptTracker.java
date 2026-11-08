package simrskhanza;

final class LoginAttemptTracker {
    private static final int MAX_FAILED_ATTEMPTS = 3;
    private static final long LOCKOUT_SECONDS = 5 * 60L;
    private static final long LOCKOUT_MILLIS = LOCKOUT_SECONDS * 1000L;

    private LoginAttemptTracker() {
    }

    static long remainingLockoutMillis(AuditHistory history) {
        if (!hasThreeRecentFailures(history) || history.secondsSinceLatestEvent >= LOCKOUT_SECONDS) {
            return 0;
        }
        return LOCKOUT_MILLIS - history.secondsSinceLatestEvent * 1000L;
    }

    static boolean shouldResetExpiredLockout(AuditHistory history) {
        return hasThreeRecentFailures(history) && history.secondsSinceLatestEvent >= LOCKOUT_SECONDS;
    }

    private static boolean hasThreeRecentFailures(AuditHistory history) {
        if (history.results.length < MAX_FAILED_ATTEMPTS) {
            return false;
        }
        for (int i = 0; i < MAX_FAILED_ATTEMPTS; i++) {
            if (!"FAILURE".equals(history.results[i])) {
                return false;
            }
        }
        return true;
    }

    static final class AuditHistory {
        final String[] results;
        final long secondsSinceLatestEvent;

        AuditHistory(String[] results, long secondsSinceLatestEvent) {
            this.results = results;
            this.secondsSinceLatestEvent = secondsSinceLatestEvent;
        }
    }
}
