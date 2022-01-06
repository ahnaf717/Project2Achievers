package project2.achievers.Entities;


    import java.util.Objects;

    public class Customer {
        private String customerName;
        private String customerUsername;
        private String customerPassword;
        private int customerZipCode;
        private int customerId;

        // default no arg constructor
        public Customer(){}

        // constructor sets all the properties
        public Customer(String customerName, String customerUsername, String customerPassword, int customerZipCode, int customerId) {
            this.customerName = customerName;
            this.customerUsername = customerUsername;
            this.customerPassword = customerPassword;
            this.customerZipCode = customerZipCode;
            this.customerId = customerId;

        }

        @Override
        public String toString() {
            return "Customer{" +
                    "customerName='" + customerName + '\'' +
                    ", customerUsername='" + customerUsername + '\'' +
                    ", customerPassword='" + customerPassword + '\'' +
                    ", customerZipCode=" + customerZipCode +
                    ", customerId=" + customerId +
                    '}';
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Customer customer = (Customer) o;
            return customerZipCode == customer.customerZipCode && customerId == customer.customerId && Objects.equals(customerName, customer.customerName) && Objects.equals(customerUsername, customer.customerUsername) && Objects.equals(customerPassword, customer.customerPassword);
        }

        @Override
        public int hashCode() {
            return Objects.hash(customerName, customerUsername, customerPassword, customerZipCode, customerId);
        }


        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        public String getCustomerUsername() {
            return customerUsername;
        }

        public void setCustomerUsername(String customerUsername) {
            this.customerUsername = customerUsername;
        }

        public String getCustomerPassword() {
            return customerPassword;
        }

        public void setCustomerPassword(String customerPassword) {
            this.customerPassword = customerPassword;
        }

        public int getCustomerZipCode() {
            return customerZipCode;
        }

        public void setCustomerZipCode(int customerZipCode) {
            this.customerZipCode = customerZipCode;
        }

        public int getCustomerId() {
            return customerId;
        }

        public void setCustomerId(int customerId) {
            this.customerId = customerId;
        }
    }

