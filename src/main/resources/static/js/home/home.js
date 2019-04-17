const $educationLevel = $('#education-level-select');
const $province = $('#province-select');
const $area = $('#area-select');

const defaultConfigEducationLevel = {
  placeholder: 'Select an option',
};
const defaultConfigProvince = {
  placeholder: 'Select an option',
};
const defaultConfigArea = {
  placeholder: 'Select an option',
};

document.addEventListener('DOMContentLoaded', function() {
  $educationLevel.select2(defaultConfigEducationLevel);
  $province.select2(defaultConfigProvince);
  $area.select2(defaultConfigArea);
});
