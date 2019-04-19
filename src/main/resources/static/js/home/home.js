const $educationLevel = $('#education-level-select');
const $province = $('#province-select');
const $area = $('#area-select');

const model = {
  selected_province_id: null,
};

const defaultConfigEducationLevel = {
  language: 'id',
  placeholder: 'Pilih salah satu',
};
const defaultConfigProvince = {
  language: 'id',
  placeholder: 'Pilih salah satu',
  width: '30%',
};
const defaultConfigArea = {
  ajax: {
    url: citiesUrl,
    delay: 500,
    headers: {
      key: 'c28f1db1a7340c866d915387d5302123',
    },
    data: getCitiesUrlParam,
    dataType: 'json',
    processResults: processResultsCity,
  },
  data: {id: null, text: null},
  disabled: 'true',
  minimumResultsForSearch: Infinity,
  language: 'id',
  placeholder: 'Pilih provinsi dahulu',
  width: '30%',
};

function getCitiesUrlParam() {
  if (model.selected_province_id) {
    return {
      province: model.selected_province_id,
    };
  }
  return '';
}

function processResultsCity(response) {
  const city = response.map(currentValue => {
    return {
      id: currentValue.id,
      text: currentValue.name,
    };
  });
  return {
    // param results is required to parse obj to select2
    results: city,
  };
}

function initSelect2() {
  $educationLevel.select2(defaultConfigEducationLevel);
  $province.select2(defaultConfigProvince);
  $area.select2(defaultConfigArea);
}

function resetAreaSelect() {
  $area.val(null).trigger('change');
  $area.select2(defaultConfigArea);
  $area.prop('disabled', false);
}

document.addEventListener('DOMContentLoaded', function() {
  initSelect2();
  $province.on('select2:select', (e) => {
    const {data} = e.params;
    model.selected_province_id = data.id;
    resetAreaSelect();
  });
});
