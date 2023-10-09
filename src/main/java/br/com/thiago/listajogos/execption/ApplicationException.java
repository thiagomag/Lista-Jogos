package br.com.thiago.listajogos.execption;

import io.r2dbc.postgresql.api.ErrorDetails;

public class ApplicationException extends RuntimeException {
    private final ErrorDetails errorDetails;

    public ApplicationException(Throwable throwable) {
        super(throwable);
        this.errorDetails = null;
    }

    public ApplicationException(ErrorDetails errorDetails) {
        this.errorDetails = errorDetails;
    }

    public ApplicationException(ErrorDetails errorDetails, Throwable throwable) {
        super(throwable);
        this.errorDetails = errorDetails;
    }

    public ErrorDetails getErrorDetails() {
        return this.errorDetails;
    }

    public String toString() {
        return "ApplicationException(errorDetails=" + this.getErrorDetails() + ")";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ApplicationException)) {
            return false;
        } else {
            ApplicationException other = (ApplicationException)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$errorDetails = this.getErrorDetails();
                Object other$errorDetails = other.getErrorDetails();
                if (this$errorDetails == null) {
                    return other$errorDetails == null;
                } else return this$errorDetails.equals(other$errorDetails);
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof ApplicationException;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        Object $errorDetails = this.getErrorDetails();
        result = result * 59 + ($errorDetails == null ? 43 : $errorDetails.hashCode());
        return result;
    }
}

