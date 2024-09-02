(ns unit.components.props-test
  (:require 
    [clojure.test :refer [is testing deftest]]
    [mockingbird.utils.props :refer [get-props]]))

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
           "w-full rounded-none shadow-none p-0 m-0 basic-class"))
    (is (= (get-props {:size :xl
                       :roundness :none
                       :shadow :none})
           "w-64 h-64 rounded-none shadow-none p-4 m-4 "))))

(deftest test-default-cases
  (testing "Check for default cases"
    (is (= (get-props {})
           "w-16 h-16 rounded-md shadow-md p-4 m-4 "))))
