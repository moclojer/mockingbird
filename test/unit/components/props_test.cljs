(ns unit.components.props-test
  (:require
   [clojure.test :refer [is testing deftest]]
   [mockingbird.helpers.props :refer [get-props]]))

(deftest test-get-props
  (testing "Check for props args"
    (is (= (get-props {:size :sm
                       :roundness :sm
                       :shadow :sm
                       :margin :sm
                       :padding :sm
                       :class "custom-class"})
           "w-8 h-8 rounded-sm shadow-sm p-2 m-2 custom-class"))
    (is (= (get-props {:size :lg
                       :roundness :full
                       :shadow :lg
                       :margin :md
                       :padding :lg
                       :class "another-class"})
           "w-32 h-32 rounded-full shadow-lg p-8 m-4 another-class"))
    (is (= (get-props {:size :full
                       :roundness :none
                       :shadow :none
                       :margin :none
                       :padding :none
                       :class "basic-class"})
           "w-full basic-class"))
    (is (= (get-props {:size :xl
                       :roundness :none
                       :shadow :none})
           "w-64 h-64 "))))

(deftest test-default-cases
  (testing "Check for default cases"
    (testing "All defaults (empty map)"
      (is (= (get-props {})
             "w-16 h-16 ")))

    (testing "Partial defaults"
      (is (= (get-props {:size :sm})
             "w-8 h-8 "))
      (is (= (get-props {:roundness :full
                         :shadow :lg})
             "w-16 h-16 rounded-full shadow-lg ")))

    (testing "Nil values"
      (is (= (get-props {:size nil
                         :roundness nil})
             "w-16 h-16 ")))))
